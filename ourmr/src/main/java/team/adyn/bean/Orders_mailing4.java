package team.adyn.bean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class Orders_mailing4 implements Writable, WritableComparable<Orders_mailing4>, DBWritable {

	private Integer lid;
	private String oid;
	private int odid;
	private int mdid;
	private int mid;
	private String cname;
	private int cid;
	private int pid;
	private int gid;
	private String gname;

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getOdid() {
		return odid;
	}

	public void setOdid(int odid) {
		this.odid = odid;
	}

	public int getMdid() {
		return mdid;
	}

	public void setMdid(int mdid) {
		this.mdid = mdid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Orders_mailing4(Integer lid, String oid, int odid, int mdid, int mid, String cname, int cid, int pid,
			int gid, String gname) {
		super();
		this.lid = lid;
		this.oid = oid;
		this.odid = odid;
		this.mdid = mdid;
		this.mid = mid;
		this.cname = cname;
		this.cid = cid;
		this.pid = pid;
		this.gid = gid;
		this.gname = gname;
	}

	public Orders_mailing4() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [lid=" + lid + ", oid=" + oid + ", odid=" + odid + ", mdid=" + mdid + ", mid=" + mid + ", cname="
				+ cname + ", cid=" + cid + ", pid=" + pid + ", gid=" + gid + ", gname=" + gname + "]";
	}

	public int compareTo(Orders_mailing4 om4) {
		// TODO Auto-generated method stub
		return this.lid - om4.lid;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, lid);
		st.setString(2, oid);
		st.setInt(3, odid);
		st.setInt(4, mdid);
		st.setInt(5, mid);
		st.setString(6, cname);
		st.setInt(7, cid);
		st.setInt(8, pid);
		st.setInt(9, gid);
		st.setString(10, gname);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.lid = re.getInt(1);
		this.oid = re.getString(2);
		this.odid = re.getInt(3);
		this.mdid = re.getInt(4);
		this.mid = re.getInt(5);
		this.cname = re.getString(6);
		this.cid = re.getInt(7);
		this.pid = re.getInt(8);
		this.gid = re.getInt(9);
		this.gname = re.getString(10);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(lid);
		out.writeUTF(oid);
		out.writeInt(odid);
		out.writeInt(mdid);
		out.writeInt(mid);
		out.writeUTF(cname);
		out.writeInt(cid);
		out.writeInt(pid);
		out.writeInt(gid);
		out.writeUTF(gname);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.lid = in.readInt();
		this.oid = in.readUTF();
		this.odid = in.readInt();
		this.mdid = in.readInt();
		this.mid = in.readInt();
		this.cname = in.readUTF();
		this.cid = in.readInt();
		this.pid = in.readInt();
		this.gid = in.readInt();
		this.gname = in.readUTF();
	}

}
