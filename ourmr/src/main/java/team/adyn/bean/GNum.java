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

public class GNum implements Writable, WritableComparable<GNum>, DBWritable {

	private Integer gid;
	private String countinfo;
	private int gcount;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getGcount() {
		return gcount;
	}

	public void setGcount(int gcount) {
		this.gcount = gcount;
	}

	public GNum(Integer gid, String countinfo, int gcount) {
		super();
		this.gid = gid;
		this.countinfo = countinfo;
		this.gcount = gcount;
	}

	public GNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GNum [gid=" + gid + ", countinfo=" + countinfo + ", gcount=" + gcount + "]";
	}

	public int compareTo(GNum g) {
		// TODO Auto-generated method stub
		return this.gid - g.gid;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, gid);
		st.setString(2, countinfo);
		st.setInt(3, gcount);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.gid = re.getInt(1);
		this.countinfo = re.getString(2);
		this.gcount = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(gid);
		out.writeUTF(countinfo);
		out.writeInt(gcount);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.gid = in.readInt();
		this.countinfo = in.readUTF();
		this.gcount = in.readInt();
	}

}
