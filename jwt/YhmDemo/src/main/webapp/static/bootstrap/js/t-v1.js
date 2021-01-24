/**
 *  T V1
 */


/**
 * displaytag paginated use it.
 * Don't change it
 *
 * @param formId
 * @param data
 */
function displaytagform(formId, data) {
    var $form = $("#" + formId);
    var action = $form.attr("action");
    var params = action.indexOf('?') == -1 ? '?' : '&';
    $.map(data, function (d) {
        params += (d.f + "=" + d.v + "&");
    });
    var url = action + params;
    var $targetDiv = $("div.displayTarget");
    if ($targetDiv.length > 0) {
        //if exist, load  the content to the div
        $targetDiv.load(url);
    } else {
        location.href = url;
    }
}

