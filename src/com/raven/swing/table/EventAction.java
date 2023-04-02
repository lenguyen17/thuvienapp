package com.raven.swing.table;

import com.raven.model.modelcomponent.ModelStudent;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);

    public void view(ModelStudent student);
    
}
