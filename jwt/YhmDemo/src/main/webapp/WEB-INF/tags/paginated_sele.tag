<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="userPaginated" required="true" type="com.idsmanager.commons.utils.paginated.DefaultPaginated" %>
<script>
    $(function () {
//        $("#selectDiv").attr("class", "pull-left form");
        var pageSelection = $("#realPageNum").removeClass("hidden");
        if (pageSelection) {
            var totalPage = "${userPaginated.totalPages}";
            for (var i = 1; i <= totalPage; i++) {
                var option = "<option value='" + i + "'>" + i + "</option>";
                pageSelection.append(option);
            }
            pageSelection.val(${userPaginated.pageNumber});
        }

        pageSelection.change(function () {
            var url = window.location.href.toString();
            var pageNumber = $(this).val();
            if (url.indexOf("?pageNumber") != -1 || url.indexOf("&pageNumber") != -1) {
                var paramName = "pageNumber";
                var re = eval('/(' + paramName + '=)([^&]*)/gi');
                url = url.replace(re, paramName + '=' + pageNumber);
            } else {
                if (url.indexOf("?") != -1) {
                    url += "&pageNumber=" + pageNumber;
                } else {
                    url += "?pageNumber=" + pageNumber;
                }
            }
            window.location.href = url;
        });
    });
</script>
