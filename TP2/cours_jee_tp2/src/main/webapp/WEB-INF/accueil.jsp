<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Le radar</title>
</head>
<body>
	<h1>Test de fonctionnement du radar Mitch 4.0</h1>
	<c:set var="vitesseRadar" value="80" scope="page" />
	<p>---- Initialisation ----</p>
	<p>
		Test pour une vitesse maximale autorisée de : ${ vitesseRadar } km/h
	</p>
	
	<!-- Affichage controle vitesse véhicule -->
	<c:forEach items="${ vehicules }" var="vehicule">
		<p>
			<c:out value="${ vehicule.nom }" />
			: ${vehicule.vitesse } km/h
			<br /> Le radar indique :
			
			<c:choose>
				<c:when test="${ vehicule.vitesse <= vitesseRadar }">
					vitesse respectée
				</c:when>
				<c:otherwise>
					une amende sera envoyée.
					<c:set target="${ vehicule }" property="recoitAmende" value="true" />
				</c:otherwise>
			</c:choose>
			
		</p>
	</c:forEach>
	
	<!-- Affichage envoi des amendes -->
	<p>---- Envoi des amendes ----</p>
	<c:set var="amendeTotal" value="0" />
	
	<!-- Version 1 : avec deux boucles par type de véhicule
	<c:forEach items="${ voitures }" var="voiture">
		<c:if test="${ voiture.recoitAmende }">
			<c:set var="amendeTotal" value="${ amendeTotal + 50 }" />
			<p><c:out value="La voiture ${ voiture.nom } a reçu une amende. Elle comporte ${ voiture.nbPassagers } passagers." /></p>
		</c:if>
	</c:forEach>
	<c:forEach items="${ motos }" var="moto">
		<c:if test="${ moto.recoitAmende }">
			<c:set var="amendeTotal" value="${ amendeTotal + 50 }" />
			<p>
				<c:out value="La moto ${ moto.nom } roulait trop vite." />
				<c:if test="${ !moto.porteCasque }">En plus, ils n'avaient pas de casque !</c:if>
			</p>
		</c:if>
	</c:forEach> -->
	
	<!-- Version 2 : avec une boucle optimisée -->
	<c:forEach items="${ vehicules }" var="vehicule">
		<c:if test="${ vehicule.recoitAmende }">
			
			<c:set var="amendeTotal" value="${ amendeTotal + 50 }" />
			
			<c:if test="${ vehicule.getClass().getSimpleName().equals('Voiture') }">
				<p>
					<c:out value="La voiture ${ vehicule.nom } a reçu une amende. 
					Elle comporte ${ vehicule.nbPassagers } passagers." />
				</p>
			</c:if>
			<c:if test="${ vehicule.getClass().getSimpleName().equals('Moto') }">
				<p>
				<c:out value="La moto ${ vehicule.nom } roulait trop vite." />
				<c:if test="${ !vehicule.porteCasque }">En plus, ils n'avaient pas de casque !</c:if>
				</p>
			</c:if>
			
		</c:if>
	</c:forEach>
	
	<c:out value="Le radar a collecté : ${ amendeTotal }" />€
	
</body>
</html>