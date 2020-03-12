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

public class MdNum3 implements Writable, WritableComparable<MdNum3>, DBWritable {

	private Integer mdid3;
	private String countinfo;
	private int mdcount3;

	public Integer getMdid3() {
		return mdid3;
	}

	public void setMdid3(Integer mdid3) {
		this.mdid3 = mdid3;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getMdcount3() {
		return mdcount3;
	}

	public void setMdcount3(int mdcount3) {
		this.mdcount3 = mdcount3;
	}

	public MdNum3(Integer mdid3, String countinfo, int mdcount3) {
		super();
		this.mdid3 = mdid3;
		this.countinfo = countinfo;
		this.mdcount3 = mdcount3;
	}

	public MdNum3() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MdNum3 [mdid3=" + mdid3 + ", countinfo=" + countinfo + ", mdcount3=" + mdcount3 + "]";
	}

	public int compareTo(MdNum3 md3) {
		// TODO Auto-generated method stub
		return this.mdid3 - md3.mdid3;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, mdid3);
		st.setString(2, countinfo);
		st.setInt(3, mdcount3);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.mdid3 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.mdcount3 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(mdid3);
		out.writeUTF(countinfo);
		out.writeInt(mdcount3);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.mdid3 = in.readInt();
		this.countinfo = in.readUTF();
		this.mdcount3 = in.readInt();
	}

}
