package sus.connection.dao;

import java.util.List;
import sus.connection.domain.Students;

public interface StudentDao {

    public void insert(Students s);

    public void update(Students s);

    public void delete(int id);

    public List<Students> getStudents();

    public Students getStudent(int id);
}
