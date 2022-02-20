function show(page) {
	if (page == 'comptes') {
		$('a').removeClass('active');
		$('a:contains(comptes)').addClass('active');
		 $("#main-content").load("GestionCompteMenu");
		event.preventDefault();
	}
	if (page == 'Cheques') {
		console.log('active')
		$('a').removeClass('active');
		$('a:contains(Cheques)').addClass('active');
		// $("#main-content").load("Chequess");
		event.preventDefault();
	}
	if (page == 'BordereauVirement') {
		$('a').removeClass('active');
		$('a:contains(BordereauVirement)').addClass('active');
		// $("#main-content").load("BordereauVirements");
		event.preventDefault();
	}
		if (page == 'Utilisateurs') {
		$('a').removeClass('active');
		$('a:contains(Utilisateurs)').addClass('active');
		// $("#main-content").load("Utilisateurs");
		event.preventDefault();
	}
	if (page == "statistiques") {
		$('a').removeClass('active');
		$('a:contains(Statistiques)').addClass('active');
		$("#main-content").load("statistiques");
		event.preventDefault();
	}
}
$('a').removeClass('active');
$('a:contains(Statistiques)').addClass('active');
$("#main-content").load("statistiques");
