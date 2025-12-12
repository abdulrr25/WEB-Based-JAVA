import React, { useEffect, useState } from 'react'
export default ProductTable(){
    const [prodarr,setprodarr]=useState([]);
    const [searcharr,setsearcharr]=useState([]);
    const [searchtxt,setsearchtxt]=useState("");
    useEffect(()=>{
        fetchdata();
    },[])
    useEffect(()=>{
        setsearcharr([...prodarr])
    },[prodarr])

    
   
}
const ProductTable = () => {
    return (
        <div>
            <Link to="/form">
                <button type="button" name="edit" id='edit'>Add new Product</button>
            </Link>
            <br /><br />

            Search: <input type='text' name='searchtxt' id='searchtxt' value={searchtxt} onChange={handleChange}></input><br />

            <table className='table table-striped'>
                <thead>
                    <tr>
                        <th scope='col'>Product Id</th>
                        <th scope='col'>Product Name</th>
                        <th scope='col'>Product Quantity</th>
                        <th scope='col'>Product Price</th>
                        <th scope='col'>Product MfgDate</th>
                        <th scope='col'>Product cid</th>
                        <th scope='col'>Action</th>
                    </tr>
                </thead>
                <tbody>

                    {searcharr.map(prod => <tr key={prod.pid}>
                        <th scope="row">{prod.pid}</th>
                        <td>{prod.pname}</td>
                        <td>{prod.qty}</td>
                        <td>{prod.price}</td>
                        <td>{prod.mfgdate}</td>
                        <td>{prod.cid}</td>
                        <td>
                            <Link to={`/table/details/${prod.pid}`}>
                                <button type="button" name="view" id="view" className="btn btn-primary">View</button></Link>&nbsp;&nbsp;&nbsp;&nbsp;

                            <button type="button" name="delete" id="delete" className="btn btn-danger" onClick={() => { deleteProduct(prod.pid) }}>delete</button>&nbsp;&nbsp;&nbsp;&nbsp;

                            <Link to={`/edit/${prod.pid}`} state={{ proddata: prod }}>
                                <button type="button" name="Edit" id="Edit"
                                    className="btn btn-warning">Edit</button></Link>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>)}
                </tbody>
            </table>
            <div>
                <outlet></outlet>
            </div>


        </div >


    )
}

