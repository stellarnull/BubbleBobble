package org.group17.Units;

import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * This is an abstract class Entity that is used to create entities.
 * 
 * @author Cas
 *
 */
public abstract class Entity extends GameObject {
	private IGravityBehaviour gravityBehaviour;
	private static final float F_THRESHOLD = 1.125f;
	private Vector vSpeed;
	private IMoveBehaviour moveBehaviour;
	private IOnCollisionWith onCollisionWithBehaviour;

	/**
	 * Sets the gravity behaviour.
	 * 
	 * @param gravityBehaviour
	 *            - the behaviour
	 */
	public void setGravityBehaviour(IGravityBehaviour gravityBehaviour) {
		this.gravityBehaviour = gravityBehaviour;
	}

	/**
	 * Applies the gravity.
	 * 
	 * @param dTimePerFrame
	 *            - The time since the last frame, See also GameHook.
	 */
	public void applyGravity(double dTimePerFrame) {
		this.gravityBehaviour.apply(dTimePerFrame, this);
	}

	/**
	 * Constructor to create an entity.
	 * 
	 * @param vLocation
	 *            - Vector respresentation of the entity in the map.
	 * @param gmMap
	 *            - The game map.
	 *            
	 * @param moveBehaviour
	 * 			  - The move behaviour for the entity.
	 * 
	 * @param collisionBehaviour
	 * 			- The collision behaviour of the entity.
	 * 
	 * * @param gravityBehaviour
	 *            - The gravityBehaviour for the entity
	 */
	public Entity(Vector vLocation, GameMap gmMap, IMoveBehaviour moveBehaviour,
			IGravityBehaviour gravityBehaviour, IOnCollisionWith collisionBehaviour) {
		super(vLocation, gmMap);
		this.vSpeed = new Vector(0, 0);
		this.moveBehaviour = moveBehaviour;
		this.gravityBehaviour = gravityBehaviour;
		this.onCollisionWithBehaviour = collisionBehaviour;
	}

	/**
	 * This method returns the speed vector.
	 * 
	 * @return this.vSpeed 
	 * 				- A vector representation of the speed.
	 */
	public Vector getSpeed() {
		return this.vSpeed;
	}

	/**
	 * This method is used to set the speed of the entity.
	 * 
	 * @param vSpeed
	 *            - A Vector that represents the speed.
	 */
	public void setSpeed(Vector vSpeed) {
		this.vSpeed = vSpeed;
	}

	/**
	 * This method applies the result of physical collision to this object.
	 * 
	 * @param goOther
	 *            - The Game Object.
	 */
	protected void applyCollision(GameObject goOther) {
		if (!goOther.collidesWith(this)) {
			return;
		}
		Vector vDiff = getLocation().subtract(goOther.getLocation());
		double dFactor = F_THRESHOLD;

		if (Math.abs(vDiff.getX()) < Math.abs(vDiff.getY())) {
			dFactor *= 1 - Math.abs(vDiff.getY());
		} else {
			dFactor *= 1 - Math.abs(vDiff.getX());
		}
		this.getSpeed().multiplyLocal(0.75);
		if (goOther instanceof Entity) {
			((Entity) goOther).getSpeed().multiplyLocal(0.75);
		}
		vDiff.multiplyLocal(dFactor);
		this.setLocation(this.getLocation().add(vDiff));
	}

	/**
	 * Method to set the OnCollisionWith behaviour.
	 * 
	 * @param onCollisionWithBehaviour
	 *            - The behaviour for when the entity collides..
	 */
	public void setOnCollisionWithBehaviour(IOnCollisionWith onCollisionWithBehaviour) {
		this.onCollisionWithBehaviour = onCollisionWithBehaviour;
	}
	
	/**
	 * Let's the entity execute behaviour if it collidies with a game object.
	 * @param goObject - The game object it is colliding with.
	 */
	public void onCollisionWith(GameObject goObject) {
		this.onCollisionWithBehaviour.onCollisionWith(this, goObject);
	}

	/**
	 * This method checks for collisions between the entities.
	 * 
	 * @param eOther
	 *            - An entity.
	 */
	public void collideWith(Entity eOther) {
		this.applyCollision(eOther);
		eOther.applyCollision(this);
		onCollisionWith(eOther);
		eOther.onCollisionWith(this);
	}

	/**
	 * This method checks for collisions with the wall and the entity.
	 * 
	 * @param wOther
	 *            - The wall object.
	 */
	public void collideWith(Wall wOther) {
		applyCollision(wOther);
		onCollisionWith(wOther);
	}

	/**
	 * This method sets the move behaviour of the entity.
	 * 
	 * @param moveB
	 *            - The move behaviour for the entity.
	 */
	public void setMoveBehaviour(IMoveBehaviour moveB) {
		this.moveBehaviour = moveB;
	}

	/**
	 * Let's the entity move according to it's move behaviour.
	 * 
	 * @param dTimePerFrame
	 *            - Time per frame in double.
	 */
	public void move(double dTimePerFrame) {
		this.moveBehaviour.move(this, dTimePerFrame);
	}
	
	/**
	 * This method sets the collisionWith behaviour of the entity.
	 * @param collisionBehaviour - The collisionWith behaviour for the entity.
	 */
	public void setCollisionBehaviour(IOnCollisionWith collisionBehaviour) {
		this.onCollisionWithBehaviour = collisionBehaviour;
	}
}