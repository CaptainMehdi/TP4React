import {useState} from "react";
import FooterAdmin from "./FooterAdmin";

const AddLivre = () => {

    const [titre, setTitre] = useState('')
    const [auteur, setAuteur] = useState('')
    const [publication, setPublication] = useState('')
    const [categorie, setCategorie] = useState('')
    const [disponibilite, setDisponibilite] = useState('')
    const [editeur, setEditeur] = useState('')
    const [nbrPage, setNbrPage] = useState('')

    const onSubmitLivre = (e) => {
        e.preventDefault()

        if (!titre) {
            alert('Ajouter le titre')
            return
        } else if (!auteur) {
            alert('Ajouter le auteur')
            return
        } else if (!publication) {
            alert('Ajouter le publication')
            return
        }
        const livre = {titre, auteur, publication, categorie, disponibilite, editeur, nbrPage}
        fetch("http://localhost:2002/todos/addLivres", {
            method: "POST",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify(livre)
        }).then(() => {
            console.log("new Livre added")
        })
        setTitre('')
        setAuteur('')
        setNbrPage('')
        setPublication('')
        setEditeur('')
        setCategorie('')
        setDisponibilite('')
    }

    return (
        <div>


            <div className="container">
                <h2 className="textBienvenue">Vous pouvez ajouter un Livre</h2>
                <form className='add-form' onSubmit={onSubmitLivre}>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Titre</label>
                        <input type='text' placeholder='Titre'
                               value={titre}
                               onChange={(e) => setTitre(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Auteur</label>
                        <input type='text' placeholder='Auteur'
                               value={auteur}
                               onChange={(e) => setAuteur(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Date de publication</label>
                        <input type='text' placeholder='Publication'
                               value={publication}
                               onChange={(e) => setPublication(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Categorie</label>
                        <input type='text' placeholder='Categorie'
                               value={categorie}
                               onChange={(e) => setCategorie(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Disponibilite</label>
                        <input type='text' placeholder='Publication'
                               value={disponibilite}
                               onChange={(e) => setDisponibilite(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Editeur</label>
                        <input type='text' placeholder='Editeur'
                               value={editeur}
                               onChange={(e) => setEditeur(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Nombre de page</label>
                        <input type='text' placeholder='Nombre de page'
                               value={nbrPage}
                               onChange={(e) => setNbrPage(e.target.value)}/>
                    </div>

                    <input type='submit' value='Save Livre' className='btn btn-block'/>
                </form>
            </div>
            <FooterAdmin/>
        </div>
    )
}
export default AddLivre