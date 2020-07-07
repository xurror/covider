import React from "react";
import {Table} from 'reactstrap';
import Widget from "components/Widget/index";

const tableList = [
  {
    key: '1',
    currency: '0.24 BTC',
    rate: '1 BTC = $740',
    date: '08.10.17',
    fee: '-$2.33'
  },
  {
    key: '2',
    currency: '0.34 RPL',
    rate: '1 RPL = $80.2',
    date: '08.03.17',
    fee: '-$1.23'
  },
  {
    key: '3',
    currency: '0.24 BTC',
    rate: '1 BTC = $740',
    date: '07.29.17',
    fee: '-$3.22'
  },
  {
    key: '4',
    currency: '0.22 BTC',
    rate: '1 BTC = $740',
    date: '07.28.17',
    fee: '-$3.22'
  },
  {
    key: '5',
    currency: '0.74 LTE',
    rate: '1 LTE = $99',
    date: '05.22.17',
    fee: '-$2.21'
  }
];

const OrderHistory = () => {
  return (
    <Widget>
      <div className="d-flex flex-row mb-3">
        <h4 className="mb-0"> Order History</h4>
        <span className="text-primary ml-auto pointer d-none d-sm-block">
                    Detailed History</span>
      </div>
      <div className="table-responsive-material">
        <Table className="default-table table-unbordered table table-sm table-hover table-nowrap table-fs-13">
          <thead className="table-head-sm th-border-b">
          <tr>
            <th>Currency</th>
            <th>Rate (USD)</th>
            <th>DATE</th>
            <th>FEE</th>
          </tr>
          </thead>
          <tbody>
          {tableList.map((data, index) => {
            return <tr key={index}>
              <td>{data.currency}</td>
              <td>{data.rate}</td>
              <td>{data.date}</td>
              <td className="text-red">{data.fee}</td>
            </tr>
          })}
          </tbody>
        </Table>
      </div>
      <span className="text-primary mt-2 pointer d-block d-sm-none">
                    Detailed History</span>
    </Widget>
  );
};

export default OrderHistory;
