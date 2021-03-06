function PageChanger(navElement, mainContainer) {
	var othis = this;
	othis.current = null;
	
	this.changePage = function(linkElement, page, constructorFunction, callback) {
		if (othis.current != null) {
			if (othis.current.close != null) {
				othis.current.close();
			}
		}
		navElement.find("li").removeClass("active");
		linkElement.addClass("active");
		mainContainer.load(page, function(response, status, xhr) {
			if (status == "error") {
				console.log(msg, xhr.status, xhr.statusText);
			} else {
				othis.current = constructorFunction.call(this);
				othis.current.show();
				if (callback != null) {
					callback.call(othis.current);
				}
			}
		});
	};
}

function TabChanger(navElement, mainContainer) {
	var othis = this;
	othis.current = null;
	othis.currentContentElement = null;
	
	this.changeTab = function(linkElement, page, contentElement, constructorFunction, callback) {
		if (othis.currentContentElement != null && contentElement != null && othis.currentContentElement.get(0) == contentElement.get(0)) {
			return;
		}
		if (othis.current != null) {
			if (othis.current.close != null) {
				othis.current.close();
			}
		}
		navElement.find("li").removeClass("active");
		mainContainer.find("> div").hide();
		linkElement.addClass("active");
		if (page != null) {
			contentElement.load(page, function(response, status, xhr) {
				if (status == "error") {
					console.log(msg, xhr.status, xhr.statusText);
				} else {
					othis.current = constructorFunction.call(this);
					contentElement.show();
					if (callback != null) {
						callback.call(othis.current);
					}
				}
			});
		} else {
			othis.current = constructorFunction.call(contentElement);
			contentElement.show();
		}
		othis.currentContentElement = contentElement;
	};
}