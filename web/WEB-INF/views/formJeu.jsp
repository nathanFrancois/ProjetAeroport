
<form class="form-horizontal" method="post" action="${action}" role="form">
    <div class="form-group">
        <label class="control-label col-sm-2" for="listeMissions">Missions associées à ce jeu</label>
        <div class="col-sm-10">
            <select class="selectpicker form-control" multiple name="listeMissions" id="listeMissions">
                <c:forEach items="${sessionScope.missions}" var="a">
                    <option value="${a.value.nummission }">${a.value.libmission}</option>
                </c:forEach>
            </select>
            <span>${form.erreurs['listeMissions']}</span>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="libelle">Libelle</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="libelle" name="libelle"
                   value="<c:out value="${jeu.libjeu}"/>"
                   size="20" maxlength="60"
                   placeholder="Entrez le libéllé"
            />
            <span>${form.erreurs['libelle']}</span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Valider</button>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

    <p> ${form.erreurs['formulaire']} </p>
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>