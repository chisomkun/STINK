package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Repair;

@Configuration
@Repository
public class RepairDao {
    @Autowired
    private JdbcTemplate jtem;

    //Query for
    public Repair getRepairByRepairID(int RepairID) {
        Repair repair = new Repair();
        try {
            String queryr = "SELECT * FROM Repair WHERE RepairID=?";
            return jtem.queryForObject(queryr, new Object[]{RepairID}, new RepairRowMapper());
        } catch (DataAccessException re) {
            System.out.println(re.getMessage());
            return repair;
        }
    }
    /*Queries for RepairByUserID
    */
}
