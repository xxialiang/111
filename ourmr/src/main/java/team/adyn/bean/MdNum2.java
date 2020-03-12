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

public class MdNum2 implements Writable, WritableComparable<MdNum2>, DBWritable {

	private Integer mdid2;
	private String countinfo;
	private int mdcount2;

	public Integer getMdid2() {
		return mdid2;
	}

	public void setMdid2(Integer mdid2) {
		this.mdid2 = mdid2;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getMdcount2() {
		return mdcount2;
	}

	public void setMdcount2(int mdcount2) {
		this.mdcount2 = mdcount2;
	}

	public MdNum2(Integer mdid2, String countinfo, int mdcount2) {
		super();
		this.mdid2 = mdid2;
		this.countinfo = countinfo;
		this.mdcount2 = mdcount2;
	}

	public MdNum2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MdNum2 [mdid2=" + mdid2 + ", countinfo=" + countinfo + ", mdcount2=" + mdcount2 + "]";
	}

	public int compareTo(MdNum2 md2) {
		// TODO Auto-generated method stub
		return this.mdid2 - md2.mdid2;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, mdid2);
		st.setString(2, countinfo);
		st.setInt(3, mdcount2);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.mdid2 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.mdcount2 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(mdid2);
		out.writeUTF(countinfo);
		out.writeInt(mdcount2);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.mdid2 = in.readInt();
		this.countinfo = in.readUTF();
		this.mdcount2 = in.readInt();
	}

}
