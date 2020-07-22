package service;

import com.stinkelectronics.helpdesk.model.Repair;

public class RepairRowMapper implements RowMapper<Repair> {

    @Override

    public Repair mapRow() {

        Repair r = new Repair();
        r.setEName();
        r.setStatus();
        r.setServiceID();
        return r;
    }
}
