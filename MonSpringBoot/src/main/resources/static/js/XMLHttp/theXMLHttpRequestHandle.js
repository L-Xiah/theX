/**
 * 监听所有的http请求
 * window.addEventListener('ajaxReadyStateChange', function (e) {console.log( e.detail); });//在js中绑定监听的事件
 */
;(function () {
    if ( typeof window.CustomEvent === "function" ) return false;

    function CustomEvent ( event, params ) {
        params = params || { bubbles: false, cancelable: false, detail: undefined };
        // noinspection ES6ConvertVarToLetConst
        var evt = document.createEvent( 'CustomEvent' );
        evt.initCustomEvent( event, params.bubbles, params.cancelable, params.detail );
        return evt;
    }

    CustomEvent.prototype = window.Event.prototype;

    // noinspection JSValidateTypes
    window.CustomEvent = CustomEvent;
})();
(function () {
    function ajaxEventTrigger(event) {
        // noinspection ES6ConvertVarToLetConst
        var ajaxEvent = new CustomEvent(event, { detail: this });
        window.dispatchEvent(ajaxEvent);
    }

    // noinspection ES6ConvertVarToLetConst
    var oldXHR = window.XMLHttpRequest;

    function newXHR() {
        // noinspection ES6ConvertVarToLetConst
        var realXHR = new oldXHR();

        realXHR.addEventListener('abort', function () { ajaxEventTrigger.call(this, 'ajaxAbort'); }, false);

        realXHR.addEventListener('error', function () { ajaxEventTrigger.call(this, 'ajaxError'); }, false);

        realXHR.addEventListener('load', function () { ajaxEventTrigger.call(this, 'ajaxLoad'); }, false);

        realXHR.addEventListener('loadstart', function () { ajaxEventTrigger.call(this, 'ajaxLoadStart'); }, false);

        realXHR.addEventListener('progress', function () { ajaxEventTrigger.call(this, 'ajaxProgress'); }, false);

        realXHR.addEventListener('timeout', function () { ajaxEventTrigger.call(this, 'ajaxTimeout'); }, false);

        realXHR.addEventListener('loadend', function () { ajaxEventTrigger.call(this, 'ajaxLoadEnd'); }, false);

        realXHR.addEventListener('readystatechange', function() { ajaxEventTrigger.call(this, 'ajaxReadyStateChange'); }, false);

        return realXHR;
    }

    // noinspection JSValidateTypes
    window.XMLHttpRequest = newXHR;
})();