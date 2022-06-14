package ch.bbzbl.dao;

import ch.bbzbl.entity.Colour;

public class ColourDAO extends GenericDAO<Colour> {

    private static final long serialVersionUID = 1L;

    public ColourDAO() {
        super(Colour.class);
    }

    public void delete(Colour colour) {
        super.delete(colour.getId());
    }

    public void find(Colour colour) { super.find(colour.getId());}

}