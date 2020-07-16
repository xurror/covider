import React,{useState} from "react";

import Widget from "components/Widget";

import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';

const users =[
            {
                "id": 1,
                "first_name": "Customer_1",
                "last_name": "Customer_11",
                "email": "customer1@mail.com",
                "phone": "00000000000",
                "address": "Customer_1 Address",
                "description": "Customer_1 description"
            },
            {
                "id": 2,
                "first_name": "Customer_2",
                "last_name": "Customer_2",
                "email": "customer2@mail.com",
                "phone": "00000000000",
                "address": "Customer_2 Adress",
                "description": "Customer_2 Description"
            },
            {
                "id": 3,
                "first_name": "Customer_3",
                "last_name": "Customer_3",
                "email": "customer3@mail.com",
                "phone": "00000000000",
                "address": "Customer_3 Adress",
                "description": "Customer_3 Description"
            }
        ]

const UserList =()=> {
  const [userList,setUserList]=useState(users);
  const [value,setValue]=useState(0);


  const  handleChange = (event, value) => {
    setValue(value);
  };

    return (
      <Widget>
        <div className="d-flex flex-row">
          <h4 className="mb-0">User List</h4>
          <span className="text-primary font-weight-medium pointer ml-auto"><i
            className="zmdi zmdi-search jr-fs-xxl ml-2 d-inline-block align-middle"/> </span>
        </div>
        <div>
                {users.length === 0 && (
                    <div className="text-center">
                        <h2>No customer found at the moment</h2>
                    </div>
                )}
                <div className="container">
                    <div className="row">
                        <table className="table table-bordered">
                            <thead className="thead-light">
                                <tr>
                                    <th scope="col">Firstname</th>
                                    <th scope="col">Lastname</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {users && users.map(customer =>
                                    <tr key={customer.id}>
                                        <td>{customer.first_name}</td>
                                        <td>{customer.last_name}</td>
                                        <td>{customer.email}</td>
                                        <td>{customer.phone}</td>
                                        <td>{customer.address}</td>
                                        <td>
                                            <div className="d-flex justify-content-between align-items-center">
                                                <div className="btn-group" style={{ marginBottom: "20px" }}>
                                                    <button className="btn btn-sm btn-outline-secondary" onClick={() => this.deleteCustomer(customer.id)}>Delete Customer</button>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
      </Widget>
    );
  }

export default UserList;
