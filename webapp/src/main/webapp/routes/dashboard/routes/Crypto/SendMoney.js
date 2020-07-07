import React from "react";
import {Table} from 'reactstrap';
import Widget from "components/Widget/index";
import Avatar from '@material-ui/core/Avatar';


const tableList = [
  {
    id: 1,
    name: 'Lucy Francis',
    image: "https://via.placeholder.com/150x150",
    lastTransfer: '17 days ago',
    action: 'Pay'
  },
  {
    id: 2,
    name: 'Dean Holmes',
    image: "https://via.placeholder.com/150x150",
    lastTransfer: '10 days ago',
    action: 'Pay'
  },
  {
    id: 3,
    name: 'Terry Bridges',
    image: "https://via.placeholder.com/150x150",
    lastTransfer: '6 days ago',
    action: 'Pay'
  },
  {
    id: 4,
    name: 'Alice Collins',
    image: "https://via.placeholder.com/150x150",
    lastTransfer: '2 hrs. ago',
    action: 'Pay'
  }
];

const SendMoney = () => {
  return (
    <Widget>
      <div className="d-flex flex-row mb-3">
        <h4 className="mb-0"> Send Money to</h4>
        <span className="text-primary ml-auto pointer d-none d-sm-inline-flex align-items-sm-center">
                    <i className="zmdi zmdi-plus-circle-o mr-1"/>Add New Account</span>
      </div>
      <div className="table-responsive-material">
        <Table className="default-table table-unbordered table table-sm table-hover">
          <thead className="table-head-sm th-border-b">
          <tr>
            <th>Account Holder Name</th>
            <th>Last Transfer</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbody>
          {tableList.map((data, index) => {
            return <tr key={index}>
              <td>
                <div className="d-flex align-items-center">
                  {data.image === '' ? null :
                    <Avatar className="user-avatar size-30" src={data.image}/>}
                  <div className="user-detail">
                    <h5 className="user-name">{data.name}</h5>
                  </div>
                </div>
              </td>
              <td>{data.lastTransfer}</td>
              <td>
                <div className="pointer text-primary">
                  <span className="d-inline-block mr-1">
                    <i className="zmdi zmdi-mail-reply zmdi-hc-fw zmdi-hc-flip-horizontal"/>
                  </span>
                  <span className="d-inline-block">{data.action}</span>
                </div>
              </td>
            </tr>
          })}
          </tbody>
        </Table>
      </div>
      <span className="text-primary mt-2 pointer d-block d-sm-none">
                    <i className="zmdi zmdi-plus-circle-o mr-1 jr-fs-lg d-inline-block align-middle"/>
                    Add New Account</span>
    </Widget>
  );
};

export default SendMoney;
