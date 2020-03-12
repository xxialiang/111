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

public class OdNum3 implements Writable, WritableComparable<OdNum3>, DBWritable {

	private Integer odid3;
	private String countinfo;
	private int odcount3;

	public Integer getOdid3() {
		return odid3;
	}

	public void setOdid3(Integer odid3) {
		this.odid3 = odid3;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getOdcount3() {
		return odcount3;
	}

	public void setOdcount3(int odcount3) {
		this.odcount3 = odcount3;
	}

	public OdNum3(Integer odid3, String countinfo, int odcount3) {
		super();
		this.odid3 = odid3;
		this.countinfo = countinfo;
		this.odcount3 = odcount3;
	}

	public OdNum3() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OdNum3 [odid3=" + odid3 + ", countinfo=" + countinfo + ", odcount3=" + odcount3 + "]";
	}

	public int compareTo(OdNum3 od3) {
		// TODO Auto-generated method stub
		return this.odid3 - od3.odid3;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, odid3);
		st.setString(2, countinfo);
		st.setInt(3, odcount3);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.odid3 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.odcount3 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(odid3);
		out.writeUTF(countinfo);
		out.writeInt(odcount3);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.odid3 = in.readInt();
		this.countinfo = in.readUTF();
		this.odcount3 = in.readInt();
	}

}