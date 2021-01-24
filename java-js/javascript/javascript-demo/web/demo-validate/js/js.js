function check()
{
    //验证用户名
    var s = document.getElementsByName('userName')[0].value;
    var reg = /^[a-z0-9]{5,10}$/i
    if(reg.test(s)==false)
    {
        alert('用户名不正确')
        return false;
    }
    //验证密码
    var s = document.getElementsByName('userPswd')[0].value;
    var reg = /^(\w|[!@#$%^&*]){6,15}$/
    if(reg.test(s)==false)
    {
        alert('密码不正确')
        return false;
    }
    //验证确认密码
    var s = document.getElementsByName('userPswd')[0].value;
    var s1 = document.getElementsByName('userPswd1')[0].value;
    if(s!=s1)
    {
        alert('密码和确认不一致')
        return false;
    }
    //验证年龄
    var s = document.getElementsByName('age')[0].value;
    var reg = /^(18|19|[2-9]\d|100)$/
    if(reg.test(s)==false)
    {
        alert('年龄不正确')
        return false;
    }
    //验证性别 单选按钮的判断
    var b = false;
    var s = document.getElementsByName('sex')
    for(i=0;i<s.length;i++)
    {
        if(s[i].checked==true)
        {	b=true;
            break;
        }

    }
    if(b==false)
    {
        alert('单选按钮必选一项')
        return false;
    }
    //验证学历 下拉列表框的判断
    var s = document.getElementsByName('edu')[0].value;
    if(s=="")
    {
        alert('学历必选一项')
        return false;
    }
    //验证爱好 复选框的判断
    var c=0;
    var s = document.getElementsByName('like')
    for(i=0;i<s.length;i++)
    {
        if(s[i].checked==true)
        {
            c++
        }
    }
    if(c<2)
    {
        alert('爱好必选两项')
        return false;
    }
    //验证自我介绍 验证文本域
    var s = document.getElementsByName('textarea1')[0].value
    if(s.length<50)
    {
        alert('自我介绍必须在50字以上')
        return false;
    }
    return true;
}