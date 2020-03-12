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

public class MdNum4 implements Writable, WritableComparable<MdNum4>, DBWritable {

	private Integer mdid4;
	private String countinfo;
	private int mdcount4;

	public Integer getMdid4() {
		return mdid4;
	}

	public void setMdid4(Integer mdid4) {
		this.mdid4 = mdid4;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getMdcount4() {
		return mdcount4;
	}

	public void setMdcount4(int mdcount4) {
		this.mdcount4 = mdcount4;
	}

	public MdNum4(Integer mdid4, String countinfo, int mdcount4) {
		super();
		this.mdid4 = mdid4;
		this.countinfo = countinfo;
		this.mdcount4 = mdcount4;
	}

	public MdNum4() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MdNum4 [mdid4=" + mdid4 + ", countinfo=" + countinfo + ", mdcount4=" + mdcount4 + "]";
	}

	public int compareTo(MdNum4 md4) {
		// TODO Auto-generated method stub
		return this.mdid4 - md4.mdid4;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, mdid4);
		st.setString(2, countinfo);
		st.setInt(3, mdcount4);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.mdid4 = re.getInt(1);
		this.countinfo = re.getString(2);
		this.mdcount4 = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(mdid4);
		out.writeUTF(countinfo);
		out.writeInt(mdcount4);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.mdid4 = in.readInt();
		this.countinfo = in.readUTF();
		this.mdcount4 = in.readInt();
	}

}
