package org.leme.z00.components.domain.user.report;

import java.util.List;

/**
 * Created by mendzl on 9/26/2016.
 */
public class RoleUserReport {

    private List<RoleUserReportItem> list;

    public RoleUserReport(List<RoleUserReportItem> list) {
        this.list = list;
    }

    public List<RoleUserReportItem> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleUserReport)) return false;

        RoleUserReport that = (RoleUserReport) o;

        return list != null ? list.equals(that.list) : that.list == null;

    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RoleUserReport{" +
                "list=" + list +
                '}';
    }
}
