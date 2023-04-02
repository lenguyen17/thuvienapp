
package com.raven.swing.tableBook;

public class ModelActionBook {

    public ModelBook getBook() {
        return book;
    }

    public void setBook(ModelBook book) {
        this.book = book;
    }

    public EventActionBook getEvent() {
        return event;
    }

    public void setEvent(EventActionBook event) {
        this.event = event;
    }

    public ModelActionBook() {
    }

    public ModelActionBook(ModelBook book, EventActionBook event) {
        this.book = book;
        this.event = event;
    }
    
    private ModelBook book;
    private EventActionBook event;
    
}
