/**
 * Component: ContactView
 *
 * Responsibilities:
 *   - Manage a single contact screen
 *   - Manage the task list of a contact
 *
 */
(function($) {
	brite.registerView("ContactView",{
		create: function(data){
			var view = this;
			
			// if the contact is given, then, just render it. 
			if (data.contact){
				view.contact = data.contact;
				return render("tmpl-ContactView",{contact:view.contact});
			}
			// otherwise, we fetch it and return the appropriate promise.
			else{
				return app.contactDao.get(data.contactId).pipe(function(contact){
					view.contact = contact;
					return render("tmpl-ContactView",{contact:contact});
				});		
			}
		},
        postDisplay: function(){
            var view = this;
            // cache some fixed elements
            view.$card = view.$el.find(".card");
            view.$cardBack = view.$el.find(".card-back");
            view.$cardFront = view.$el.find(".card-front");
            view.$sectionContent = view.$el.find("section.content");
        },
	});

})(jQuery); 