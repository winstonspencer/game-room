package com.gameroom;

public class Entity {

    private long id;
    private String name;

    /**
     * The default constructor creates a new <code>Entity</code>>
     * with the id set to 0 and the name set to null.
     *
     * @param id   The entity ID
     * @param name The entity name.
     */
    private Entity() {
        this.id = 0L;
        this.name = null;
    }

    /**
     * The Entity constructor creates a new <code>Entity</code> object
     * with the specified id and name.
     *
     * @param id   The player ID
     * @param name The player name.
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the entity id
     */
    public long getId() {
        return this.id;
    }

    /**
     * @return the entity name
     */
    public String getName() {
        return this.name;
    }

    /**
     * The string representation of the <code>Entity</code> object.
     *
     * @return
     */
    public String toString() {
        return "Player [id=" + id + ", name=" + name + "]";
    }

}
