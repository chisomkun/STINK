package service;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import com.stinkelectronics.helpdesk.model.Repair;

public class RepairRowMapper implements RowMapper<Repair> {

    @Override
    public Repair mapRow(ResultSet rs, int rowNum) throws SQLException {

        Repair r = new Repair();
        r.setEName(r.getEName("EName"));
        r.setStatus(r.getStatus("Status"));
        r.setServiceID(r.getServiceID("ServiceID"));
        return r;
    }
}
