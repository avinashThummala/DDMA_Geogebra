/*
Copyright (C) 2007 Alex Billingsley, email@abillingsley.co.uk
www.dragmath.bham.ac.uk

This file is part of DragMath

    DragMath is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation.

    DragMath is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with DragMath.  If not, see <http://www.gnu.org/licenses/>
 */
package Tree;


/**
 * Class to represent a Text object, consisting of a string of characters
 * @author Alex Billingsley
 */
public class Text extends MathObject {
    
    private String text;
    
    /** Creates a new instance of Text 
     * Initialises the parameters
     */
    public Text(String text) {
        super(-1, "");
        this.text = text;
    }

    /** Returns the string of text
     * @return The string of text
     */
    public String getText() {
        return text;
    }
    

}
