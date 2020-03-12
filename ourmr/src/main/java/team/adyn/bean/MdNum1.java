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

public class MdNum1 implements Writable, WritableComparable<MdNum1>, DBWritable {

	private Integer mdid1;
	private String countinfo;
	private int mdcount1;

	public Integer getMdid1() {
		return mdid1;
	}

	public void setMdid1(Integer mdid1) {
		this.mdid1 = mdid1;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getMdcount1() {
		return mdcount1;
	}

	public void setMdcount1(int mdcount1) {
		this.mdcount1 = mdcount1;
	}

	public MdNum1(Integer mdid1, String countinfo, int mdcount1) {
		super();
		this.mdid1 = mdid1;
		this.countinfo = countinfo;
		this.mdcount1 = mdcount1;
	}

	public MdNum1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MdNum1 [mdid1=" + mdid1 + ", countinfo=" + countinfo + ", mdcount1=" + mdcount1 + "]";
	}

	public int compareTo(MdNum1 md1) {
		// TODO Auto-generated method stub
		return this.mdid1 - md1.mdid1;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, mdid1);
		st.setString(2, countinfo);
		st.setInt(3, mdcount1);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.mdid1 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.mdcount1 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(mdid1);
		out.writeUTF(countinfo);
		out.writeInt(mdcount1);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.mdid1 = in.readInt();
		this.countinfo = in.readUTF();
		this.mdcount1 = in.readInt();
	}

}
