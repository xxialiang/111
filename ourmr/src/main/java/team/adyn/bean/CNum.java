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

public class CNum implements Writable, WritableComparable<CNum>, DBWritable {

	private Integer cid;
	private String countinfo;
	private int ccount;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getCcount() {
		return ccount;
	}

	public void setCcount(int ccount) {
		this.ccount = ccount;
	}

	public CNum(Integer cid, String countinfo, int ccount) {
		super();
		this.cid = cid;
		this.countinfo = countinfo;
		this.ccount = ccount;
	}

	public CNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CNum [cid=" + cid + ", countinfo=" + countinfo + ", ccount=" + ccount + "]";
	}

	public int compareTo(CNum c) {
		// TODO Auto-generated method stub
		return this.cid - c.cid;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, cid);
		st.setString(2, countinfo);
		st.setInt(3, ccount);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.cid = re.getInt(1);
		this.countinfo = re.getString(2);
		this.ccount = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(cid);
		out.writeUTF(countinfo);
		out.writeInt(ccount);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.cid = in.readInt();
		this.countinfo = in.readUTF();
		this.ccount = in.readInt();
	}

}
