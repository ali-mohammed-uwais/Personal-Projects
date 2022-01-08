package assignment8;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Entity {

	private boolean isZombie;
	private double x;
	private double y;
	private double radius;

	/**
	 * @param isZombie the undead state of this Entity. true if zombie, false
	 *                 otherwise.
	 * @param x        the x-coordinate of this Entity's center.
	 * @param y        the y-coordinate of this Entity's center.
	 */
	public Entity(boolean isZombie, double x, double y) {

		this.isZombie = isZombie;
		this.x = x;
		this.y = y;
		this.radius = 0.008;
	}

	/**
	 * @return true if zombie, false otherwise
	 */
	public boolean isZombie() {

		if (isZombie) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return the center x-coordinate
	 */
	public double getX() {

		return x;
	}

	/**
	 * @return the center y-coordinate
	 */
	public double getY() {

		return y;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {

		return radius;
	}

	/**
	 * Draw this Entity.
	 */
	public void draw() {

		if (isZombie) {
			StdDraw.setPenColor(Color.red);
			StdDraw.filledCircle(x, y, radius);
		} else {
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.filledCircle(x, y, radius);
		}
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @return distance between this Entity's center and the specified other point.
	 */
	public double distanceCenterToPoint(double xOther, double yOther) {

		Double distance = 0.0;
		Double distance_X_Calculation = Math.pow((this.x - xOther), 2);
		Double distance_Y_Calculation = Math.pow((this.y - yOther), 2);
		distance = Math.sqrt(distance_X_Calculation + distance_Y_Calculation);
		return distance;

	}

	/**
	 * @param other the other Entity
	 * @return the distance between this Entity's center and the specified other
	 *         Entity's center.
	 */
	public double distanceCenterToCenter(Entity other) {
		return distanceCenterToPoint(other.getX(), other.getY());
	}

	/**
	 * @param xOther      the x-coordinate of another Entity's center.
	 * @param yOther      the y-coordinate of another Entity's center.
	 * @param radiusOther the radius of another Entity.
	 * @return the distance between this Entity's edge and the specified other
	 *         Entity's edge.
	 */
	public double distanceEdgeToEdge(double xOther, double yOther, double radiusOther) {

		return distanceCenterToPoint(xOther, yOther) - (radiusOther + radius);
	}

	/**
	 * @param other the other Entity.
	 * @return the distance between this Entity's edge and the specified other
	 *         Entity's edge.
	 */
	public double distanceEdgeToEdge(Entity other) {
		return distanceEdgeToEdge(other.getX(), other.getY(), other.getRadius());
	}

	/**
	 * @param xOther      the x-coordinate of another Entity's center.
	 * @param yOther      the y-coordinate of another Entity's center.
	 * @param radiusOther the radius of another Entity.
	 * @return true if the bounding circle of this Entity overlaps with the bounding
	 *         circle of the specified other Entity, false otherwise.
	 */
	public boolean isTouching(double xOther, double yOther, double radiusOther) {
		double comparingRadius = distanceEdgeToEdge(xOther, yOther, radiusOther);
		if (comparingRadius <= 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param other the other Entity
	 * @return true if the bounding circle of this Entity overlaps with the bounding
	 *         circle of the specified other Entity, false otherwise.
	 */
	public boolean isTouching(Entity other) {
		return isTouching(other.getX(), other.getY(), other.getRadius());
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @param amount the amount to move toward the point.
	 */
	public void moveToward(double xOther, double yOther, double amount) {
		double xVector = xOther - getX();
		double yVector = yOther - getY();
		double angle = Math.atan2(yVector, xVector);
		double xAmount = amount * Math.cos(angle);
		double yAmount = amount * Math.sin(angle);
		this.x += xAmount;
		this.y += yAmount;

	}

	/**
	 * @param other  the other Entity
	 * @param amount the amount to move toward the other Entity.
	 */
	public void moveToward(Entity other, double amount) {
		moveToward(other.getX(), other.getY(), amount);
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @param amount the amount to move away from the point.
	 */
	public void moveAwayFrom(double xOther, double yOther, double amount) {
		moveToward(xOther, yOther, -amount);

	}

	/**
	 * @param other  the other Entity
	 * @param amount the amount to move away from the other Entity.
	 */
	public void moveAwayFrom(Entity other, double amount) {
		moveAwayFrom(other.getX(), other.getY(), amount);
	}

	/**
	 * @param entities          this list of entities to search.
	 * @param includeZombies    whether to include zombies in this search or not.
	 * @param includeNonzombies whether to include nonzombies in this search or not.
	 * @return the closest Entity to this Entity in entities (which is not this).
	 */
	private Entity findClosest(List<Entity> entities, boolean includeZombies, boolean includeNonzombies) {
		Entity closest = null;
		double closestDist = Double.MAX_VALUE;
		for (Entity other : entities) {
			// NOTE:
			// We almost always want to use the equals method when comparing Objects.
			// In this case, we check if the two entities are the exact same instance.
			if (this != other) {
				if ((other.isZombie() && includeZombies) || (!other.isZombie() && includeNonzombies)) {
					double dist = distanceEdgeToEdge(other);
					if (dist < closestDist) {
						closest = other;
						closestDist = dist;
					}
				}
			}
		}
		return closest;
	}

	/**
	 * @param entities this list of entities to search.
	 * @return the closest nonzombie to this Entity in entities (which is not this).
	 */
	public Entity findClosestNonzombie(List<Entity> entities) {
		return findClosest(entities, false, true);
	}

	/**
	 * @param entities this list of entities to search.
	 * @return the closest zombie to this Entity in entities (which is not this).
	 */
	public Entity findClosestZombie(List<Entity> entities) {
		return findClosest(entities, true, false);
	}

	/**
	 * @param entities this list of entities to search.
	 * @return the closest Entity to this Entity in entities (which is not this).
	 */
	public Entity findClosestEntity(List<Entity> entities) {
		return findClosest(entities, true, true);
	}

	/**
	 * Updates the appropriate state (instance variables) of this Entity for the
	 * current frame of the simulation.
	 * 
	 * @param entities  list of remaining entities in the simulation. It is likely
	 *                  that this Entity will be one of the entities in the list.
	 *                  Care should be taken to not overreact to oneself.
	 * @param deltaTime the change in time since the previous frame
	 * 
	 * @return true if this Entity remains in existence past the current frame,
	 *         false if consumed
	 */
	public boolean update(List<Entity> entities, double deltaTime) {
   
		if (isZombie()) {
			Entity approachThis = findClosestNonzombie(entities); // finding a completely closest nonZombie
			if(approachThis == null) {
				return true;
			}
			double amountToApproach = distanceEdgeToEdge(approachThis.getX(), approachThis.getY(), approachThis.getRadius()) * deltaTime;
			if(amountToApproach < 0.02) {
				amountToApproach = 0.02;
			}
			
			moveToward(approachThis, amountToApproach);
			if (this.x > 1) {
				this.x = 0.99;
			} else if (this.x < 0) {
				this.x = 0.01;
			}
			if (this.y > 1) {
				this.y = 0.99;
			} else if (this.y < 0) {
				this.y = 0.01;
			}

			return true; // its gonna be true regardless as this is a zombie
		} else {
			
			Entity runAwayFromThis = findClosestZombie(entities);
			if(runAwayFromThis == null) {
				return true;
			}
			if (isTouching(runAwayFromThis.getX(), runAwayFromThis.getY(), runAwayFromThis.getRadius())) { // if it is touching the
																							// zombie a bit complicated
				double chance = Math.random();
				if (chance > 0.20) { // 80% of time the nonZombie will transform into zombies
					this.isZombie = true;
					return true;
				} else {
                    
					runAwayFromThis.x += 0.02;
					return false;
				}
			} 
			else { // if it is not touching the zombie
				double amountToRunAway = distanceEdgeToEdge(runAwayFromThis.x, runAwayFromThis.y,
						runAwayFromThis.radius) * 0.5 * deltaTime;
				moveAwayFrom(runAwayFromThis, amountToRunAway);
				if (this.x > 1) {
					this.x = 0.99;
				} else if (this.x < 0) {
					this.x = 0.01;
				}
				if (this.y > 1) {
					this.y = 0.99;
				} else if (this.y < 0) {
					this.y = 0.01;
				}

				return true; // again you won't be erasing the nonzombie cuz it didn't get eaten
			}

		}

	}

}
