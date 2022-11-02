package domain.service;

import domain.model.Project;
import domain.model.Workorder;

import java.util.ArrayList;

public interface WorkorderService {
    void addWorkorder(Workorder workorder);

    void deleteWorkorder(int id);

    void updateWorkorder(int id,Workorder workorder);

    Workorder getWorkorderWithId(int id);
    ArrayList<Workorder> getAllWorkorders();
}
