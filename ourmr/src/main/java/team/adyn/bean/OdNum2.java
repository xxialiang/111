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

public class OdNum2 implements Writable, WritableComparable<OdNum2>, DBWritable {

	private Integer odid2;
	private String countinfo;
	private int odcount2;

	public Integer getOdid2() {
		return odid2;
	}

	public void setOdid2(Integer odid2) {
		this.odid2 = odid2;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getOdcount2() {
		return odcount2;
	}

	public void setOdcount2(int odcount2) {
		this.odcount2 = odcount2;
	}

	public OdNum2(Integer odid2, String countinfo, int odcount2) {
		super();
		this.odid2 = odid2;
		this.countinfo = countinfo;
		this.odcount2 = odcount2;
	}

	public OdNum2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OdNum2 [odid2=" + odid2 + ", countinfo=" + countinfo + ", odcount2=" + odcount2 + "]";
	}

	public int compareTo(OdNum2 od2) {
		// TODO Auto-generated method stub
		return this.odid2 - od2.odid2;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, odid2);
		st.setString(2, countinfo);
		st.setInt(3, odcount2);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.odid2 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.odcount2 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(odid2);
		out.writeUTF(countinfo);
		out.writeInt(odcount2);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.odid2 = in.readInt();
		this.countinfo = in.readUTF();
		this.odcount2 = in.readInt();
	}

}