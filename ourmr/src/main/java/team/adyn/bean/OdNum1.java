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

public class OdNum1 implements Writable, WritableComparable<OdNum1>, DBWritable {

	private Integer odid1;
	private String countinfo;
	private int odcount1;

	public Integer getOdid1() {
		return odid1;
	}

	public void setOdid1(Integer odid1) {
		this.odid1 = odid1;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getOdcount1() {
		return odcount1;
	}

	public void setOdcount1(int odcount1) {
		this.odcount1 = odcount1;
	}

	public OdNum1(Integer odid1, String countinfo, int odcount1) {
		super();
		this.odid1 = odid1;
		this.countinfo = countinfo;
		this.odcount1 = odcount1;
	}

	public OdNum1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OdNum1 [odid1=" + odid1 + ", countinfo=" + countinfo + ", odcount1=" + odcount1 + "]";
	}

	public int compareTo(OdNum1 od1) {
		// TODO Auto-generated method stub
		return this.odid1 - od1.odid1;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, odid1);
		st.setString(2, countinfo);
		st.setInt(3, odcount1);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.odid1 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.odcount1 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(odid1);
		out.writeUTF(countinfo);
		out.writeInt(odcount1);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.odid1 = in.readInt();
		this.countinfo = in.readUTF();
		this.odcount1 = in.readInt();
	}

}