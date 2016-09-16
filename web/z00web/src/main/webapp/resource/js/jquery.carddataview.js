$.widget( "carddaraview", {
    options: {
        value: 0
    },
    _create: function() {
    	var self = this,
			o = self.options;
    	var contentWrapper =  self.element;
    	contentWrapper.addClass("content-wrapper");
    	
    	var content =  $("<div></div>")
    	content.addClass("content");
    	
    	var row =  $("<div></div>");
    	row.addClass("row");
    	
    	var col =  $("<div></div>");
    	col.addClass("col-lg-2 col-md-3 col-sm-6 col-xs-12");

    	var infoBox =  $("<div></div>");
    	col.addClass("col-lg-2 col-md-3 col-sm-6 col-xs-12");    	
    	
        var cap = $("<span></span>").text(el.attr("alt")).addClass("ui-widget ui-caption").css({
            backgroundColor: o.backgroundColor,
            color: o.color,
            width: el.width()
        });
        
        
        
//        <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
//        <div class="info-box">
//          <!-- span class="info-box-icon bg-white"><i class="ion ion-person-add"></i></span -->
//          <div class="info-box-content-np">            	
//            <span class="info-box-text">Leanid Mendzeleu</span>
//            <span class="info-box-number">leon</span>
//            <span class="info-box-text">L.Mendelev@gmail.com</span>
//          </div>
//          <!-- /.info-box-content -->
//        </div>
//        <!-- /.info-box -->
//      </div>        
//        

//        <div class="content-wrapper">
//    	<div class="content">
//    	   <div class="row">
    	
    	
    	
    	
        this.options.value = this._constrain(this.options.value);
        this.element.addClass( "progressbar" );
        this.refresh();
    },
    _setOption: function( key, value ) {
        if ( key === "value" ) {
            value = this._constrain( value );
        }
        this._super( key, value );
    },
    _setOptions: function( options ) {
        this._super( options );
        this.refresh();
    },
    refresh: function() {
        var progress = this.options.value + "%";
        this.element.text( progress );
        if ( this.options.value == 100 ) {
            this._trigger( "complete", null, { value: 100 } );
        }
    },
    _constrain: function( value ) {
        if ( value > 100 ) {
            value = 100;
        }
        if ( value < 0 ) {
            value = 0;
        }
        return value;
    }
});