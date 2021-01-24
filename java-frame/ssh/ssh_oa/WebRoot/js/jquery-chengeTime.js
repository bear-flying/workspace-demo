var Common = {
    /**
     * 格式化日期（不含时间"00:00:00"）
     */
    formatterDate1: function (date) {
        if (date == undefined) {
            return "";
        }
        /*json格式时间转js时间格式*/
       var date1 = date.time;
        var obj = new Date(date1);
        /*把日期格式化*/
        var datetime = obj.getFullYear()+"/"+obj.getMonth()+"/"+obj.getDate();
        return datetime;
    },
    /**
     * 格式化去日期（含时间）
     */
    formatterDate2: function (date) {
        if (date == undefined) {
            return "";
        }
        /*json格式时间转js时间格式*/
       // date = date.substr(1, date.length - 2);
        var date1 = date.time;
        var obj = new Date(date1);
      	var datetime = obj.getFullYear()+"/"+obj.getMonth()+"/"+obj.getDate()+" "+obj.getHours()+":"+obj.getMinutes()+":"+obj.getSeconds();
        return datetime;
    }
	};