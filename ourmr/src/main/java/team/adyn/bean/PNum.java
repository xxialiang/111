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

public class PNum implements Writable, WritableComparable<PNum>, DBWritable {

	private Integer pid;
	private String countinfo;
	private int pcount;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	public PNum(Integer pid, String countinfo, int pcount) {
		super();
		this.pid = pid;
		this.countinfo = countinfo;
		this.pcount = pcount;
	}

	public PNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PNum [pid=" + pid + ", countinfo=" + countinfo + ", pcount=" + pcount + "]";
	}

	public int compareTo(PNum p) {
		// TODO Auto-generated method stub
		return this.pid - p.pid;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, pid);
		st.setString(2, countinfo);
		st.setInt(3, pcount);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.pid = re.getInt(1);
		this.countinfo = re.getString(2);
		this.pcount = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(pid);
		out.writeUTF(countinfo);
		out.writeInt(pcount);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.pid = in.readInt();
		this.countinfo = in.readUTF();
		this.pcount = in.readInt();
	}

}
