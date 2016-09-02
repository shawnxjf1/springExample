##base64 相关注意问题
jdk base64 当字符达到一定的数量会换行，而apache不会换行

怎么处理：
从优酷里找base64的代码

import com.youku.paycenter.common.util.Base64Util;