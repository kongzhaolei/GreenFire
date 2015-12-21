package com.needle.greenfire.Model;

import com.needle.greenfire.dao.CaseDao;
import com.needle.greenfire.dao.CaseStepDao;
import com.needle.greenfire.dao.IndexDao;
import com.needle.greenfire.dao.KeyWordDao;
import com.needle.greenfire.dao.LocatorDao;
import com.needle.greenfire.dao.ProjectDao;
import com.needle.greenfire.dao.RunTestCaseDao;
import com.needle.greenfire.dao.SettingDao;
import com.needle.greenfire.dao.UserDao;
import com.needle.greenfire.dao.impl.CaseDaoImpl;
import com.needle.greenfire.dao.impl.CaseStepDaoImpl;
import com.needle.greenfire.dao.impl.IndexDaoImpl;
import com.needle.greenfire.dao.impl.KeyWordDaoImpl;
import com.needle.greenfire.dao.impl.LocatorDaoImpl;
import com.needle.greenfire.dao.impl.ProjectDaoImpl;
import com.needle.greenfire.dao.impl.RunTestCaseDaoImpl;
import com.needle.greenfire.dao.impl.SettingDaoImpl;
import com.needle.greenfire.dao.impl.UserDaoImpl;
import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.IndexInfo;
import com.needle.greenfire.po.KeyName;
import com.needle.greenfire.po.KeyWord;
import com.needle.greenfire.po.LocatName;
import com.needle.greenfire.po.ProInfo;
import com.needle.greenfire.po.Project;
import com.needle.greenfire.po.ReportCase;
import com.needle.greenfire.po.ReportCaseStep;
import com.needle.greenfire.po.Result;
import com.needle.greenfire.po.RunCase;
import com.needle.greenfire.po.Setting;
import com.needle.greenfire.po.TestCase;
import com.needle.greenfire.po.User;

import java.util.List;
import java.util.Map;

public class Model {
	private UserDao ud = new UserDaoImpl();
	private ProjectDao pd = new ProjectDaoImpl();
	private KeyWordDao kwd = new KeyWordDaoImpl();
	private CaseDao cd = new CaseDaoImpl();
	private IndexDao idao = new IndexDaoImpl();
	private CaseStepDao csd = new CaseStepDaoImpl();
	private LocatorDao ld = new LocatorDaoImpl();
	private SettingDao sd = new SettingDaoImpl();
	private RunTestCaseDao rtcd = new RunTestCaseDaoImpl();

	public User userLogin(String name, String password) {
		return this.ud.userLogin(name, password);
	}

	public User getUser(String name) {
		return this.ud.SelectOneUser(name);
	}

	public Map findAllUsers() {
		return this.ud.findAllUsers();
	}

	public boolean DeleteUser(int[] ids) {
		return this.ud.deleteUsers(ids);
	}

	public boolean AddUser(User user) {
		return this.ud.addUser(user);
	}

	public boolean updateUser(User user) {
		return this.ud.updateUser(user);
	}

	public boolean checkPassWord(String name, String password) {
		return this.ud.checkPassWord(name, password).booleanValue();
	}

	public boolean checkNameExist(String name) {
		return this.ud.checkNameExist(name);
	}

	public Map getAllProject() {
		return this.pd.getAllProject();
	}

	public boolean AddProject(Project project) {
		return this.pd.addProject(project);
	}

	public boolean updateProCaseNum(int pid) {
		return this.pd.updateProCaseNum(pid);
	}

	public boolean DeleteProject(int[] ids) {
		return this.pd.deleteProjects(ids);
	}

	public Project getProjectInfo(int pid) {
		return this.pd.getProjectInfo(pid);
	}

	public boolean UpdateProject(Project project) {
		return this.pd.updateProject(project);
	}

	public List<ProInfo> findCaseRroInfo() {
		return this.pd.findCaseRroInfo();
	}

	public Map findAllKeyWord() {
		return this.kwd.findAllKeyWord();
	}

	public boolean addKeyWord(KeyWord keyWord) {
		return this.kwd.addKeyword(keyWord);
	}

	public boolean deleteKeyWord(int[] kids) {
		return this.kwd.deleteKeyWord(kids);
	}

	public KeyWord getKeyWordInfo(int kid) {
		return this.kwd.getKeyWordInfo(kid);
	}

	public boolean updateKeyWord(KeyWord keyWord) {
		return this.kwd.updateKeyword(keyWord);
	}

	public List<KeyName> findKeyNameInfo() {
		return this.kwd.findKeyNameInfo();
	}

	public List<LocatName> findLocatNameInfo() {
		return this.ld.findLocatNameInfo();
	}

	public List<TestCase> FindProCaseInfo(int pid) {
		return this.cd.FindProCaseInfo(pid);
	}

	public boolean AddTestCase(TestCase testCase) {
		return this.cd.AddTestCase(testCase);
	}

	public int getAddTestCaseID(int pid, String title) {
		return this.cd.getAddTestCaseID(pid, title);
	}

	public TestCase findTestCaseInfo(int pid, int tcid) {
		return this.cd.findTestCaseInfo(pid, tcid);
	}

	public List<CaseStep> FindCaseStepInfo(int pid, int tcid) {
		return this.csd.FindCaseStepInfo(pid, tcid);
	}

	public boolean addCaseStep(CaseStep caseStep) {
		return this.csd.addCaseStep(caseStep);
	}

	public boolean checkCaseStepID(int pid, int tcid, int tsid) {
		return this.csd.checkCaseStepID(pid, tcid, tsid);
	}

	public boolean updateCaseStep(CaseStep caseStep) {
		return this.csd.updateCaseStep(caseStep);
	}

	public boolean updateTestCase(TestCase testCase) {
		return this.cd.updateTestCase(testCase);
	}

	public List<ReportCaseStep> FindCaseStepInfo(int pid) {
		return this.csd.FindCaseStepInfo(pid);
	}

	public List<ReportCase> FindReportCaseInfo(int pid) {
		return this.cd.FindReportCaseInfo(pid);
	}

	public List<IndexInfo> findIndexInfo() {
		return this.idao.findIndexInfo();
	}

	public List<RunCase> findCaseRunInfo() {
		return this.idao.findCaseRunInfo();
	}

	public String getRemodeURL(int pid, String localURL) {
		return this.sd.getRemodeURL(pid, localURL);
	}

	public boolean addProjectSetting(Setting setting) {
		return this.sd.addProjectSetting(setting);
	}

	public Map findSettingInfo(int pid) {
		return this.sd.findSettingInfo(pid);
	}

	public Setting getSettingInfo(int sid, int pid) {
		return this.sd.getSettingInfo(sid, pid);
	}

	public boolean updateSetting(Setting setting) {
		return this.sd.updateSetting(setting);
	}

	public List<Project> findProjects() {
		return this.rtcd.findProjects();
	}

	public List<CaseStep> findCaseSteps(int tcid) {
		return this.rtcd.findCaseSteps(tcid);
	}

	public boolean addResult(Result result) {
		return this.rtcd.addResult(result);
	}

	public boolean updateFailNum(int pid) {
		return this.rtcd.updateFailNum(pid);
	}
}
