<div>
<h2>README</h2>

<p>Members of the <a href="https://www.oasis-open.org/committees/odata/">OASIS Open Data Protocol (OData) TC</a> create and manage technical content in this TC GitHub repository ( <a href="https://github.com/oasis-tcs/odata-abnf">https://github.com/oasis-tcs/odata-abnf</a> ) as part of the TC's chartered work (<i>i.e.</i>, the program of work and deliverables described in its <a href="https://www.oasis-open.org/committees/odata/charter.php">charter</a>).</p>

<p>OASIS TC GitHub repositories, as described in <a href="https://www.oasis-open.org/resources/tcadmin/github-repositories-for-oasis-tc-members-chartered-work">GitHub Repositories for OASIS TC Members' Chartered Work</a>, are governed by the OASIS <a href="https://www.oasis-open.org/policies-guidelines/tc-process">TC Process</a>, <a href="https://www.oasis-open.org/policies-guidelines/ipr">IPR Policy</a>, and other policies, similar to TC Wikis, TC JIRA issues tracking instances, TC SVN/Subversion repositories, etc.  While they make use of public GitHub repositories, these TC GitHub repositories are distinct from <a href="https://www.oasis-open.org/resources/open-repositories">OASIS TC Open Repositories</a>, which are used for development of open source <a href="https://www.oasis-open.org/resources/open-repositories/licenses">licensed</a> content.</p>
</div>

<div>
<h3>Description</h3>

<p>The purpose of this repository is to develop and maintain <a href="https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_form">ABNF-based</a> grammars for OData Uniform Resource Identifiers, request and response headers, and literal data values in request and response bodies. Each grammar is accompanied by a set of positive and negative test cases that serve as examples for what is intended and not intended, and that can also be used to automatically test the grammars.</p>
</div>

<div>
<h3>Contributions</h3>
<p>As stated in this repository's <a href="https://github.com/oasis-tcs/odata-abnf/blob/master/CONTRIBUTING.md">CONTRIBUTING file</a>, contributors to this repository are expected to be Members of the OASIS OData TC, for any substantive change requests.  Anyone wishing to contribute to this GitHub project and <a href="https://www.oasis-open.org/join/participation-instructions">participate</a> in the TC's technical activity is invited to join as an OASIS TC Member.  Public feedback is also accepted, subject to the terms of the <a href="https://www.oasis-open.org/policies-guidelines/ipr#appendixa">OASIS Feedback License</a>.</p>
</div>



<div>
<h3>Licensing</h3>
<p>Please see the <a href="https://github.com/oasis-tcs/odata-abnf/blob/master/LICENSE.md">LICENSE</a> file for description of the license terms and OASIS policies applicable to the TC's work in this GitHub project. Content in this repository is intended to be part of the OData TC's permanent record of activity, visible and freely available for all to use, subject to applicable OASIS policies, as presented in the repository <a href="https://github.com/oasis-tcs/odata-abnf/blob/master/LICENSE.md">LICENSE</a> file.</p>
</div>

<div>
<h3>Further Description of this Repository</h3>
There are currently three pairs of grammars and test cases:

* Core [grammar](abnf/odata-abnf-construction-rules.txt) and [test cases](abnf/odata-abnf-testcases.xml)
* Data Aggregation Extension [grammar](abnf/odata-aggregation-abnf.txt) and [test cases](abnf/odata-aggregation-testcases.xml)
* Temporal Data Extension [grammar](abnf/odata-temporal-abnf.txt) and [test cases](abnf/odata-temporal-testcases.xml)

The grammars of the two extensions are incremental and add new alternatives to "Core" rules as well as new rules used in the new alternatives.

</div>


<div>
<h3>Contact</h3>
<p>Please send questions or comments about <a href="https://www.oasis-open.org/resources/tcadmin/github-repositories-for-oasis-tc-members-chartered-work">OASIS TC GitHub repositories</a> to <a href="mailto:robin@oasis-open.org">Robin Cover</a> and <a href="mailto:chet.ensign@oasis-open.org">Chet Ensign</a>.  For questions about content in this repository, please contact the TC Chair or Co-Chairs as listed on the the OData TC's <a href="https://www.oasis-open.org/committees/odata/">home page</a>.</p>
</div>
