/**
 * Created by Valentin on 25/06/2016.
 */
function notificationInsertUserCorrect()
{
    var notify = $.notify('<strong>Sauvegarde</strong> Ne pas fermer la page ...', {
        type: 'success',
        allow_dismiss: false,
        showProgressbar: true
    });
    setTimeout(function() {
        notify.update('message', '<strong>Sauvegarde</strong> du nouvel utilisateur');
    }, 1000);
    setTimeout(function() {
        notify.update('message', '<strong>Sauvegarde</strong> des nouvelles données');
    }, 2000);
    setTimeout(function() {
        notify.update('message', '<strong>Vérification</strong> des erreurs');
    }, 3000);
    setTimeout(function() {
        notify.update('message', '<strong>Le compte a été crée avec succés !</strong>');
    }, 4000);
}
function notificationUpdateUserCorrect()
{
    var notify = $.notify('<strong>Sauvegarde</strong> Ne pas fermer la page ...', {
        type: 'success',
        allow_dismiss: false,
        showProgressbar: true
    });
    setTimeout(function() {
        notify.update('message', '<strong>Mise à jour</strong> des informations de l\'utilisateur');
    }, 2000);
    setTimeout(function() {
        notify.update('message', '<strong>Les informations ont été modifiées avec succés !</strong>');
    }, 5000);
}
function notificationLoginIncorrect()
{
    $.notify("La combinaison login/mdp est incorrecte ou le compte demandé n'a pas encore été activé", {
        type: 'danger',
        animate: {
            enter: 'animated zoomInDown',
            exit: 'animated zoomOutUp'
        }
    });
}
