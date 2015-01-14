package me.chanjar.weixin.cp.api;

import java.util.List;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.bean.WxCpDepart;
import me.chanjar.weixin.cp.bean.WxCpUser;

import org.junit.Assert;

/**
 * 测试用户接口
 *
 * @author Daniel Qian
 */
public class WxCpUserAPITest {

  protected WxCpServiceImpl wxCpService;

  protected WxCpDepart depart;

  public void testUserCreate() throws WxErrorException {
    WxCpUser user = new WxCpUser();
    user.setUserId("xiaohe.yang");
    user.setName("杨宝");
    user.setDepartIds(new Integer[] { 9, 8 });
    user.setEmail("yangxiaohe@ddd.com");
    user.setGender("女");
    user.setMobile("13564684979");
    user.setPosition("老婆");
    user.setTel("3300393");
    user.addExtAttr("爱好", "老公");
    wxCpService.userCreate(user);
  }

  public void testUserUpdate() throws WxErrorException {
    WxCpUser user = new WxCpUser();
    user.setUserId("xiaohe.yang");
    user.setName("杨宝");
    user.addExtAttr("爱好", "老公2");
    wxCpService.userUpdate(user);
  }

  public void testUserGet() throws WxErrorException {
    WxCpUser user = wxCpService.userGet("xiaohe.yang");
    Assert.assertNotNull(user);
  }

  public void testDepartGetUsers() throws WxErrorException {
    List<WxCpUser> users = wxCpService.departGetUsers(1, true, 0);
    Assert.assertNotEquals(users.size(), 0);
  }

  public void testUserDelete() throws WxErrorException {
    wxCpService.userDelete("xiaohe.yang");
  }
}
