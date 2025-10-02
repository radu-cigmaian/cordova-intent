var exec = require('cordova/exec');

exports.openUrl = function (url, success, error) {
    exec(success, error, "OpenUrlPlugin", "openUrl", [url]);
};