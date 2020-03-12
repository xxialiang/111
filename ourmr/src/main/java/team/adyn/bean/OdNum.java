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

public class OdNum implements Writable, WritableComparable<OdNum>, DBWritable {

	private Integer odid;
	private String countinfo;
	private int odcount;

	public Integer getOdid() {
		return odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getOdcount() {
		return odcount;
	}

	public void setOdcount(int odcount) {
		this.odcount = odcount;
	}

	public OdNum(Integer odid, String countinfo, int odcount) {
		super();
		this.odid = odid;
		this.countinfo = countinfo;
		this.odcount = odcount;
	}

	public OdNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OdNum [odid=" + odid + ", countinfo=" + countinfo + ", odcount=" + odcount + "]";
	}

	public int compareTo(OdNum od) {
		// TODO Auto-generated method stub
		return this.odid - od.odid;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, odid);
		st.setString(2, countinfo);
		st.setInt(3, odcount);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.odid = re.getInt(1);
		this.countinfo = re.getString(2);
		this.odcount = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(odid);
		out.writeUTF(countinfo);
		out.writeInt(odcount);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.odid = in.readInt();
		this.countinfo = in.readUTF();
		this.odcount = in.readInt();
	}

}
