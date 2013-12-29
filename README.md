# DeviceInformation plugin for Phonegap #

This plugin allows you to retrieve most information about your Android devices that are available through Android's Telephony Manager class from your PhoneGap application.

## Adding the Plugin to your project ##

Assuming the PhoneGap CLI is installed, from the command line run:

phonegap local plugin add https://github.com/vliesaputra/DeviceInformationPlugin

## Using the plugin ##

<pre>
  /**
    * Get the devices information.
    */
  get(success, failure)
</pre>

Sample use:
<pre>
    var onSuccess = function (obj) {
	alert (
		"deviceID:" 	+ deviceID  	+ '\n' + 
                "phoneNo:" 	+ phoneNo  	+ '\n' + 
                "netCountry:" 	+ netCountry  	+ '\n' + 
                "netName:"  	+ netName  	+ '\n' + 
                "simCountry:"  	+ simCountry  	+ '\n' + 
                "simName:" 	+ simName  	+ '\n');
    };
	
    function onError(error) {
	alert('Error: '  + error);
    }
	
    deviceinformation.get(onSuccess,onError);
</pre>    

## RELEASE NOTES ##

### December 29, 2013 ###

* Initial release


## BUGS AND CONTRIBUTIONS ##


## LICENSE ##

This plugin is available under the MIT License (2008). 
The text of the MIT license is reproduced below. 

---

### The MIT License

Copyright (c) &lt;2013&gt; Veronica Liesaputra

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 
