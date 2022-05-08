const listeDocuments = [
    {
        id: 1,
        titre: 'La vie en Rose',
        auteur: 'Jean lebeau',
        publication : '9 septembre 1029',
        categorie: 'Comedie',
        type:'Livre'

    },
    {
        id: 2,
        titre: 'Cours',
        auteur: 'Habiii mani',
        publication : '20 juin 2000',
        categorie: 'Comedie',
        type:'Livre'

    },
]

const ListeDocument = () =>{
    return (
        <>
            {listeDocuments.map((document) => (<h2>{document.titre}</h2>))}
        </>
    )
}

export default ListeDocument