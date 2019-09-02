system = require('system')  
address = system.args[1];
var page = require('webpage').create();  
page.settings.userAgent= 'Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR2.0.50727)';
var url = address;  
page.open(url, function (status) {  
    //Page is loaded!  
    if (status !== 'success') {  
        console.log('Unable to post!');  
    } else {  
            window.setTimeout(function () {
              page.render("test1.png");  //截图
              console.log(page.content);
              phantom.exit();
          }, 5000);   
    } 
  });   