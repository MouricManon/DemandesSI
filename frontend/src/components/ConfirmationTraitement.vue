<template>
    <!-- Bouton de suppression -->
    <button type="button" class="btn btn-success" data-bs-toggle="modal" :data-bs-target="`#modal${id}`">Traité</button>

    <!-- Modal -->
    <div class="modal fade" :id="`modal${id}`" tabindex="-1" aria-labelledby="Confirmation Traitement"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <!-- Texte du titre -->
                    <h5 class="modal-title">Confirmation de Traitement</h5>
                    <!-- Croix pour fermer -->
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div><!-- Message principal -->
                <div class="modal-body">Êtes vous sûr d'avoir traité cette demande ?</div>
                <div class="modal-footer">
                    <!-- Bouton annuler -->
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                    <!-- Bouton valider -->
                    <button type="button" class="btn btn-success" @click="$emit('TraitementConfirmed', id)"
                        data-bs-dismiss="modal">Valider</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
defineProps(["id"]);
const emit = defineEmits(['TraitementConfirmed']);
</script>