package com.cdintelligent.znzx.common.pojo;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description: session上下文.</p>
 * <p>Copyright: Copyright(c) 2017.</p>
 * <p>Company: 成都四方.</p>
 * <p>CreateTime: 2017/1/10.</p>
 *
 * @author SF2121
 * @version 1.0
 */
public class SessionContext
{
    /**
     * 用户ID
     */
    public static final String USER_ID = "userId";
    /**
     * 用户
     */
    public static final String USER = "user";
    /**
     * response
     */
    public static final String RESPONSE = "response";
    /**
     * request
     */
    public static final String REQUEST = "request";
    /**
     * locale
     */
    public static final String LOCALE = "locale";
    /**
     * CTX
     */
    private static final ThreadLocal<SessionContext> CTX = new ThreadLocal<SessionContext>();
    /**
     * US
     */
//    private static IUserService us = null;
    /**
     * 属性值
     */
    private Map<String, Object> attributes = new HashMap<String, Object>();

    /**
     * 构造方法
     *
     * @return SessionContext 上下文
     */
    public static SessionContext get()
    {
        return CTX.get();
    }

    /**
     * set
     *
     * @param context 上下文
     */
    public static void set(SessionContext context)
    {
        CTX.set(context);
    }

//    /**
//     * getUserService
//     *
//     * @return IUserService
//     */
//    private static IUserService getUserService()
//    {
//        if (us == null)
//        {
//            us = ServiceUtils.get(IUserService.SERVICE_ID, IUserService.class);
//        }
//        return us;
//    }

    /**
     * copy
     *
     * @return 上下文
     */
    public SessionContext copy()
    {
        SessionContext context = new SessionContext();
        context.attributes.putAll(attributes);
        return context;
    }

    /**
     * current
     *
     * @param key 键
     * @return 对象
     */
    public Object current(String key)
    {
        return attributes.get(key);
    }

    /**
     * current
     *
     * @param key   键
     * @param value 值
     */
    public void current(String key, Object value)
    {
        attributes.put(key, value);
    }

    /**
     * currentRequest
     *
     * @return HttpServletRequest HttpServletRequest
     */
    public HttpServletRequest currentRequest()
    {
        return (HttpServletRequest) current(REQUEST);
    }

    /**
     * currentRequest
     *
     * @param request request
     */
    public void currentRequest(HttpServletRequest request)
    {
        current(REQUEST, request);
    }

    /**
     * currentResponse
     *
     * @return HttpServletResponse HttpServletResponse
     */
    public HttpServletResponse currentResponse()
    {
        return (HttpServletResponse) current(RESPONSE);
    }

    /**
     * currentResponse
     *
     * @param response response
     */
    public void currentResponse(HttpServletResponse response)
    {
        current(RESPONSE, response);
    }

    /**
     * currentUser
     */
//    @SuppressWarnings("unchecked")
//    public GSUser currentUser()
//    {
//        GSUser u = (GSUser) current(USER);
//        if (u == null)
//        {
//            Long id = (Long) current(USER_ID);
//            if (id != null && (u = getUserService().getUserByUserId(id)) != null)
//            {
//                currentUser(u);
//            }
//        }
//        return u;
//    }
//    
    /**
     * 获取当前用户所在机关id
     */
//    public List<Long> listGovernmentOrgIdsByCurrentUser()
//    {
//    	GSUser currentUser = currentUser();
//    	Set<DeptInfo> deptInfos  = currentUser.getDepts();
//    	if(!Tools.isEmpty(deptInfos)){
//    		List<Long> orgIds = new ArrayList<>();
//    		for (DeptInfo deptInfo : deptInfos) {
//    			if(Tools.isNotNull(deptInfo) && Tools.isNotNull(deptInfo.getRegisOrgan())){
//    				orgIds.add(deptInfo.getRegisOrgan().getOrgId());
//    			}
//    		}
//    		return orgIds;
//    	}
//    	return null;
//    }
    
    
    /**
     * 获取当前用户
     *
     * @param user 用户
     */
//    public void currentUser(GSUser user)
//    {
//        current(USER, user);
//    }

    /**
     * 获取当前用户ＩＤ
     *
     * @return string 字符串
     */
//    public Long currentUserId()
//    {
//        Long userId = (Long) current(USER_ID);
//        if (userId == null)
//        {
//            GSUser u = (GSUser) current(USER);
//            if (u != null)
//            {
//                current(USER_ID, userId = u.getUserId());
//            }
//        }
//        return userId;
//    }

    /**
     * 获取当前用户ＩＤ
     *
     * @param userId 用户ID
     */
    public void currentUserId(Long userId)
    {
        current(USER_ID, userId);
    }

    /**
     * currentLocale
     *
     * @return 字符串
     */
    public String currentLocale()
    {
        return (String) current(LOCALE);
    }

    /**
     * currentLocale
     *
     * @param locale locale
     */
    public void currentLocale(String locale)
    {
        current(LOCALE, locale);
    }
}
